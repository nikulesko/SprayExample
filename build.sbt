name := "SprayExample"

version := "1.0"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val sprayVersion: String = "1.1.1"
val akkaVersion: String = "2.1.4"

libraryDependencies ++= {
  Seq(
    "io.spray"            %   "spray-can"      % sprayVersion,
    "io.spray"            %   "spray-routing"  % sprayVersion,
    "com.typesafe.akka"   %%  "akka-actor"     % akkaVersion
  )
}

libraryDependencies += "commons-lang"   % "commons-lang"    % "2.6"

libraryDependencies += "org.json4s"     %% "json4s-native"  % "3.2.4"

libraryDependencies += "org.json4s"     %% "json4s-jackson" % "3.2.4"

libraryDependencies += "org.squeryl"    % "squeryl_2.10"    % "0.9.5-6"

libraryDependencies += "commons-dbcp"   % "commons-dbcp"    % "1.3"

libraryDependencies += "com.h2database" % "h2"              % "1.3.174"

Revolver.settings
    