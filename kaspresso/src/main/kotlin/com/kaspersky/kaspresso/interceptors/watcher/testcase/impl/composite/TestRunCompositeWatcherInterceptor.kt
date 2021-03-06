package com.kaspersky.kaspresso.interceptors.watcher.testcase.impl.composite

import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.internal.extensions.other.forEachSafely
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

/**
 * The implementation of the [TestRunWatcherInterceptor] interface.
 * Composes all of [TestRunWatcherInterceptor]s list into one composite [TestRunWatcherInterceptor] that is actually
 * called by [com.kaspersky.kaspresso.testcases.core.TestRunner] on each test event.
 */
class TestRunCompositeWatcherInterceptor(
    private val watcherInterceptors: List<TestRunWatcherInterceptor>,
    private val exceptions: MutableList<Throwable>
) : TestRunWatcherInterceptor {

    /**
     * Called on the whole test starts, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onTestStarted(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onTestStarted(testInfo) }
    }

    /**
     * Called on "before" section starts, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onBeforeSectionStarted(testInfo) }
    }

    /**
     * Called on "before" section finishes with success, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onBeforeSectionFinishedSuccess(testInfo) }
    }

    /**
     * Called on "before" section finishes with failure, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     * @param throwable the error occured to pass to  [watcherInterceptors].
     */
    override fun onBeforeSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        watcherInterceptors.forEachSafely(exceptions) { it.onBeforeSectionFinishedFailed(testInfo, throwable) }
    }

    /**
     * Called on "main" section starts, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onMainSectionStarted(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onMainSectionStarted(testInfo) }
    }

    /**
     * Called on "main" section finishes with success, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onMainSectionFinishedSuccess(testInfo) }
    }

    /**
     * Called on "main" section finishes with failure, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     * @param throwable the error occured to pass to  [watcherInterceptors].
     */
    override fun onMainSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        watcherInterceptors.forEachSafely(exceptions) { it.onMainSectionFinishedFailed(testInfo, throwable) }
    }

    /**
     * Called on "after" section starts, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onAfterSectionStarted(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onAfterSectionStarted(testInfo) }
    }

    /**
     * Called on "after" section finishes with success, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     */
    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        watcherInterceptors.forEachSafely(exceptions) { it.onAfterSectionFinishedSuccess(testInfo) }
    }

    /**
     * Called on "after" section finishes with failure, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     * @param throwable the error occured to pass to  [watcherInterceptors].
     */
    override fun onAfterSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        watcherInterceptors.forEachSafely(exceptions) { it.onAfterSectionFinishedFailed(testInfo, throwable) }
    }

    /**
     * Called on the whole test finishes, delegates the interception to [watcherInterceptors].
     *
     * @param testInfo the test info to pass to [watcherInterceptors].
     * @param success the while test was finished successfully or not, to pass to [watcherInterceptors].
     */
    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        watcherInterceptors.forEachSafely(exceptions) { it.onTestFinished(testInfo, success) }
    }
}