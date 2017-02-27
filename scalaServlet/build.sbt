
name := "servletScala"

version := "1.0.0-SNAPSHOT"
 
scalaVersion := "2.11.8"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

libraryDependencies += "com.github.manliogit" % "javatags" % "0.4.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

enablePlugins(JettyPlugin)

