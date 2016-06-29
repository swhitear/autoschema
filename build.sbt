lazy val root = (project in file(".")).enablePlugins(VersioningPlugin)

name := "autoschema"

organization := "com.sauldhernandez"

scalaVersion := "2.11.7"

semanticVersion := Version(1, 0, 0)

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.5.1",
  "org.scalatest" %% "scalatest" % "2.1.7" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

useGpg := true

usePgpKeyHex("34de53dd")

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

pomExtra := <url>https://github.com/sauldhernandez/autoschema</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>https://opensource.org/licenses/Apache-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:sauldhernandez/autoschema.git</url>
    <connection>scm:git:git@github.com:sauldhernandez/autoschema.git</connection>
  </scm>
  <developers>
    <developer>
      <id>coursera</id>
      <name>Coursera</name>
    </developer>
    <developer>
      <id>sauldhernandez</id>
      <name>Saul Hernandez</name>
      <url>http://github.com/sauldhernandez</url>
    </developer>
  </developers>