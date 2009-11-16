/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package org.codehaus.groovy.grails.test.junit3

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.test.report.junit.JUnitReportsFactory

/**
 * Convenience factory for creating JUnit3 based integration test runners.
 */
class JUnit3GrailsIntegrationTestTypeRunnerFactory {

    static JUnit3GrailsIntegrationTestTypeRunner createRunner(type, Binding buildBinding) {
        buildBinding.with {
            def app = appCtx.getBean(GrailsApplication.APPLICATION_ID)
            new JUnit3GrailsIntegrationTestTypeRunner(
                type,
                testNames,
                grailsSettings, 
                classLoader, 
                resolveResources,
                JUnitReportsFactory.createFromBuildBinding(buildBinding),
                appCtx,
            )
        }
    }

}