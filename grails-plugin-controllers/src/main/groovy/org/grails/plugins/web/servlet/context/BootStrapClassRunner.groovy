/*
 * Copyright 2014 original authors
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
package org.grails.plugins.web.servlet.context

import grails.core.GrailsApplication
import grails.core.GrailsApplicationLifeCycleAdapter
import grails.core.support.GrailsApplicationAware
import org.grails.web.servlet.context.GrailsConfigUtils
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.web.context.ServletContextAware
import org.springframework.web.context.WebApplicationContext

import javax.servlet.ServletContext



/**
 * Runs the BootStrap classes on startup
 *
 * @author Graeme Rocher
 * @since 3.0
 */
class BootStrapClassRunner extends GrailsApplicationLifeCycleAdapter implements GrailsApplicationAware, ServletContextAware, ApplicationContextAware {

    GrailsApplication grailsApplication
    ApplicationContext applicationContext
    ServletContext servletContext

    @Override
    void onStartup(Map<String, Object> event) {
        if(grailsApplication && applicationContext && servletContext) {
            GrailsConfigUtils.executeGrailsBootstraps(grailsApplication, (WebApplicationContext)applicationContext, servletContext )
        }
    }
}
