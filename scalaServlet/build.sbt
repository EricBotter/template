
name := "servletScala"

version := "1.0.0-SNAPSHOT"
 
scalaVersion := "2.11.8"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

libraryDependencies += "com.github.manliogit" % "javatags" % "0.4.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.16.1"

libraryDependencies += "com.zaxxer" % "HikariCP" % "2.6.1"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.4.1.v20170120" % "container,test"


enablePlugins(JettyPlugin)

