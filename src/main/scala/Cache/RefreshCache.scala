package Cache

import scala.concurrent.duration.FiniteDuration

/*
import com.google.common.cache._
import com.google.common.util.concurrent.{ListenableFuture, _}
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.{Executor, FutureTask, TimeUnit}

import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration
import scala.reflect.ClassTag
import scala.util.{Failure, Success}
*/

case class RefreshingCacheConfig(
                                  initialCapacity: Int,
                                  maximumSize: Int,
                                  refreshPeriod: FiniteDuration,
                                  batchTime: FiniteDuration,
                                  maxBatchSize: Int
                                )

/**
  * Cache which automatically refreshes values (only those which have been accessed).
  * Function which is set by initLoadFunc is used to load values and put them in the cache.
  * Requested values are batched before being passed to the load function.
  *
  * Values in the cache are not refreshed in background. All maintenance occurs in the moments when
  * the cache is accessed. So, if you don't access your cache, no maintenance will be done.
  *
  */

/*
trait RefreshingCache[K, V] {

  val config: RefreshingCacheConfig

  def get(key: K): Future[Option[V]]

  def clear(): Unit

  def initLoadFunc(loadFunc: List[K] => Future[Map[K, V]]): Unit
}
*/

/*
class RefreshingCacheImpl[K: ClassTag, V: ClassTag](
                                                     name: String,
                                                     override val config: RefreshingCacheConfig
                                                   )(implicit actorSystem: ActorSystem)
  extends RefreshingCache[K, V] {

  private var refreshActor: Option[ActorRef] = None

  private implicit val askPatternTimeout: Timeout = 120.seconds

  private val itemsRefreshed = new AtomicLong(0)

  private val cache = CacheBuilder
    .newBuilder()
    .asInstanceOf[CacheBuilder[K, Future[Option[V]]]]
    .initialCapacity(config.initialCapacity)
    .maximumSize(config.maximumSize)
    .recordStats()
    .refreshAfterWrite(config.refreshPeriod.toSeconds, TimeUnit.SECONDS)
    .expireAfterAccess(config.refreshPeriod.toSeconds * 2, TimeUnit.SECONDS)
    .build(new CacheLoader[K, Future[Option[V]]] {
      override def load(key: K): Future[Option[V]] = loadValue(key)
      override def reload(key: K, oldValue: Future[Option[V]]): ListenableFuture[Future[Option[V]]] =
        refreshValue(key)
    })

  actorSystem.scheduler.schedule(1.minute, 1.minute) {
    val stats = cache.stats()

    val size          = cache.size
    val hitRate       = (stats.hitRate() * 100).toLong
    val evictionCount = stats.evictionCount()
    val loadCount     = stats.loadCount()

    logger.debug(Markers.RefreshingCache, s"No of items in the $name cache: $size")
    logger.debug(Markers.RefreshingCache, s"Cache Hit rate the $name: $hitRate")
    logger.debug(Markers.RefreshingCache, s"No of evictions the $name cache: $evictionCount")
    logger.debug(Markers.RefreshingCache, s"No of item loads the $name cache: $loadCount")
    logger.debug(Markers.RefreshingCache, s"No of item refreshes the $name cache: $itemsRefreshed")

    val tags = Map(Metrics.tagRefreshingCacheName -> name)
    reportingService.wfReporter.report(Metrics.refreshingCacheSize, size, tags)
    reportingService.wfReporter.report(Metrics.refreshingCacheHitRate, hitRate, tags)
    reportingService.wfReporter.report(Metrics.refreshingCacheEvictionsCount, evictionCount, tags)
    reportingService.wfReporter.report(Metrics.refreshingCacheLoadsCount, loadCount, tags)
    reportingService.wfReporter.report(Metrics.refreshingCacheRefreshesCount, itemsRefreshed.getAndSet(0), tags)
  }

  def initLoadFunc(loadFunc: List[K] => Future[Map[K, V]]): Unit =
    refreshActor = Some(
      actorSystem.actorOf(
        Props(new BatchingActor[K, V](name, config.batchTime, reportingService, loadFunc, config.maxBatchSize))
      )
    )

  def get(key: K): Future[Option[V]] = {
    if (refreshActor.isEmpty)
      throw new IllegalStateException("Load function is not set")
    cache.get(key)
  }

  override def clear(): Unit = cache.invalidateAll()

  private def loadValue(key: K): Future[Option[V]] = {
    logger.debug(Markers.RefreshingCache, s"Attempting to load value with key: $key")
    refreshActor.get.ask(key).mapTo[Option[V]]
  }

  private def refreshValue(key: K): ListenableFuture[Future[Option[V]]] = {
    logger.debug(Markers.RefreshingCache, s"Refreshing value with key: $key")
    val loadFuture = loadValue(key)
    val task       = new CompletableListenableFutureTask[Future[Option[V]]](loadFuture)
    loadFuture.onComplete {
      case Success(_) =>
        itemsRefreshed.incrementAndGet()
        task.set(loadFuture)
      case Failure(ex) =>
        itemsRefreshed.incrementAndGet()
        task.setException(ex)
    }
    task
  }
}
*/

/**
  * This class is copied from com.google.common.util.concurrent.ListenableFutureTask.
  * Due to the nature of this case, we need to manually complete the ListenableFuture instances
  * by setting the result (or exception). Required setters have protected-access modifiers, so, to call
  * them, we have to extend the class. Unfortunately, we cannot extend the ListenableFutureTask, as
  * all of it's constructors have package-private. Thus, only one solution wasto copy-paste it's implementation.
  */
/*
private class CompletableListenableFutureTask[T](result: T)
  extends FutureTask[T](EMPTY_RUNNABLE, result)
    with ListenableFuture[T] {
  private val executionList: ExecutionList = new ExecutionList()
  override def addListener(listener: Runnable, exec: Executor): Unit =
    executionList.add(listener, exec)
  override protected def done(): Unit           = executionList.execute()
  override def setException(t: Throwable): Unit = super.setException(t)
  override def set(v: T): Unit                  = super.set(v)
}

object CompletableListenableFutureTask {
  val EMPTY_RUNNABLE = new Runnable {
    override def run(): Unit = {}
  }
}
*/
