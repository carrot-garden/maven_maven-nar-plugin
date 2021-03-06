package org.apache.maven.plugin.nar;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Move the GNU style include/lib to some output directory
 * 
 * @goal nar-gnu-resources
 * @phase process-resources
 * @requiresProject
 * @author Mark Donszelmann
 */
public class NarGnuResources
    extends AbstractGnuMojo
{
    public final void narExecute()
        throws MojoExecutionException, MojoFailureException
    {
        if ( getGnuSourceDirectory().exists() )
        {
            int copied = 0;
            
            try
            {
                copied += copyIncludes( getGnuSourceDirectory() );
            }
            catch ( IOException e )
            {
                throw new MojoFailureException( "NAR: Gnu could not copy resources", e );
            }
            
            if (copied > 0) {
                getLog().info( "Copied "+copied+" GNU resources" );
            }

        }
    }
}
