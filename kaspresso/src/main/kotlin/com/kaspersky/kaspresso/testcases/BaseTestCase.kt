package com.kaspersky.kaspresso.testcases

import com.kaspersky.kaspresso.configurator.Configurator
import com.kaspersky.kaspresso.testcases.models.TestBody
import com.kaspersky.kaspresso.testcases.sections.AfterTestSection
import com.kaspersky.kaspresso.testcases.sections.BeforeTestSection

/**
 *  A base class for all parametrized test cases. Extend this class with a single base project-wide inheritor of [TestCase] as a
 *  parent for all actual project-wide test cases. Nesting test cases are not permitted because they may produce an
 *  exception caused by re-initialization of the [Configurator], use [Scenario] instead.
 *
 *  @param BeforeSectionData data initialized in before section
 *  @param MainSectionData data transformed from [BeforeSectionData] by special function
 */
abstract class BaseTestCase<BeforeSectionData, MainSectionData>(
    configBuilder: Configurator.Builder = Configurator.Builder.default(),
    private val dataProducer: (((BeforeSectionData.() -> Unit)?) -> MainSectionData)
) {
    private val testCaseName = javaClass.simpleName

    /**
     * Finishes building of [Configurator]. Passing [Configurator.Builder] to base [TestCase]'s constructor is the only
     * way for project-wide inheritor of [TestCase] to tune [Configurator].
     */
    init {
        configBuilder.commit()
    }

    /**
     * Starts the building a test, sets the [BeforeTestSection] actions and returns an existing instance of
     * [AfterTestSection] to continue building a test.
     *
     * @param actions actions to invoke in before test section.
     * @return an existing instance of [AfterTestSection].
     */
    protected fun before(actions: () -> Unit): AfterTestSection<BeforeSectionData, MainSectionData> {
        return BeforeTestSection(
            TestBody.Builder<BeforeSectionData, MainSectionData>().apply {
                testName = testCaseName
                mainDataProducer = dataProducer
            }
        ).beforeTest(actions)
    }
}