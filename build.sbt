name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

resolvers += "Artifactory" at "http://artifactory-gojek.golabs.io/artifactory/gojek-release-local/"

libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

// XGBoost hosted on Artifactory
libraryDependencies += "ml.dmlc" % "xgboost4j" % "0.7"
libraryDependencies += "com.esotericsoftware" % "kryo" % "4.0.0"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.4"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
