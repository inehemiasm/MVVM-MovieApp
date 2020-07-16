package com.example.inehemias.mvvmmovieapp.testutils

import org.junit.Ignore
import org.junit.runner.notification.RunNotifier
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.InitializationError
import timber.log.Timber

/**
 * Android JUnit Tag Runner utility
 */
//class SetupTags @Throws(InitializationError::class)
//constructor(c: Class<*>) : BlockJUnit4ClassRunner(c) {
//    override fun runChild(method: FrameworkMethod, notifier: RunNotifier) {
//        val description = describeChild(method)
//        val testConfigTags = TestSetup.tags
//        var runMethod = false
//        if (method.getAnnotation(Ignore::class.java) != null) {
//            notifier.fireTestIgnored(description)
//        } else if (method.getAnnotation(TestTags::class.java) != null) {
//            val testTags = method.getAnnotation(TestTags::class.java).toString()
//            // get all tag names from test method
//            val methodTags = testTags.replace(".*\\[".toRegex(), "").replace("\\]".toRegex(), "").replace("\\)".toRegex(), "").replace(" ".toRegex(), "")
//            val tagsFromMethod = methodTags.split(",".toRegex())
//            for (testConfigTag in testConfigTags) {
//                for (tagFromMethod in tagsFromMethod) {
//                    Timber.e("Test tag = $tagFromMethod")
//                    if (tagFromMethod.equals(testConfigTag, ignoreCase = true) && !testConfigTag.startsWith("#")) {
//                        runLeaf(methodBlock(method), description, notifier)
//                        runMethod = true
//                        break
//                    }
//                }
//            }
//            if (!runMethod) {
//                notifier.fireTestIgnored(description)
//            }
//        } else {
//            runLeaf(methodBlock(method), description, notifier)
//        }
//    }
//}

class AndroidTags @Throws(InitializationError::class)
constructor(c: Class<*>) : BlockJUnit4ClassRunner(c) {
    override fun runChild(method: FrameworkMethod, notifier: RunNotifier) {
        val description = describeChild(method)
        val testConfigTags = TestSetup.tags
        var runMethod = false
        if (method.getAnnotation(Ignore::class.java) != null) {
            notifier.fireTestIgnored(description)
        } else if (method.getAnnotation(TestTags::class.java) != null) {
            val testTags = method.getAnnotation(TestTags::class.java).toString()
            // get all tag names from test method
            val methodTags = testTags.replace(".*\\[".toRegex(), "").replace("\\]".toRegex(), "").replace("\\)".toRegex(), "").replace(" ".toRegex(), "")
            val tagsFromMethod = methodTags.split(",".toRegex())
            for (testConfigTag in testConfigTags) {
                for (tagFromMethod in tagsFromMethod) {
                    Timber.e("Test tag = $tagFromMethod")
                    if (tagFromMethod.equals(testConfigTag, ignoreCase = true) && !testConfigTag.startsWith("#")) {
                        runLeaf(methodBlock(method), description, notifier)
                        runMethod = true
                        break
                    }
                }
            }
            if (!runMethod) {
                notifier.fireTestIgnored(description)
            }
        } else {
            runLeaf(methodBlock(method), description, notifier)
        }
    }
}