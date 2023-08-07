package rules_scala3.deps

import sbt.librarymanagement.syntax.*

object Deps:
  def main(args: Array[String]): Unit =
    given Vars = Vars(args.toIndexedSeq).getOrElse(sys.exit(2))

    given DepsCfg = DepsCfg(
      resolvers = Vector(
        "mavencentral".at("https://repo1.maven.org/maven2/"),
        "sonatype releases".at("https://oss.sonatype.org/service/local/repositories/releases/content"),
        "apache staging".at("https://repository.apache.org/content/repositories/staging"),
        "apache snapshots".at("https://repository.apache.org/snapshots"),
        "google".at("https://maven.google.com/"),
        "jitsi-maven-repository".at("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases")
      ),

      // Replacements are not handled by `librarymanagement`. any Scala prefix in the name will be dropped.
      // It also doesn't matter whether you use double `%` to get the Scala version or not.
      replacements = Map(
        "org.scala-lang" % "scala3-library" -> "@scala_library_3_3_1//jar",
        "org.scala-lang" % "scala-library" -> "@scala_library_2_13_11//jar",
        "org.scala-lang" % "scala-reflect" -> "@scala_reflect_2_13_11//jar"
      ),
      dependencies = Vector(
        "io.sentry"                     % "sentry"                                     % "6.14.0",
        ("io.netty.incubator"           % "netty-incubator-transport-native-io_uring"  % "0.0.21.Final").classifier("linux-x86_64"),
        "io.netty.incubator"            % "netty-incubator-transport-classes-io_uring" % "0.0.21.Final",
        ("io.netty"                     % "netty-transport-native-epoll"               % "4.1.95.Final").classifier("linux-x86_64"),
        "io.netty"                      % "netty-buffer"                               % "4.1.95.Final",
        "io.netty"                      % "netty-codec-http"                           % "4.1.95.Final",
        "io.netty"                      % "netty-codec-http2"                          % "4.1.95.Final",
        "io.netty"                      % "netty-codec-dns"                            % "4.1.95.Final",
        "io.netty"                      % "netty-codec"                                % "4.1.95.Final",
        "io.netty"                      % "netty-common"                               % "4.1.95.Final",
        "io.netty"                      % "netty-handler"                              % "4.1.95.Final",
        "io.netty"                      % "netty-resolver"                             % "4.1.95.Final",
        "io.netty"                      % "netty-resolver-dns"                         % "4.1.95.Final",
        "io.netty"                      % "netty-transport"                            % "4.1.95.Final",
        "io.netty"                      % "netty-transport-classes-epoll"              % "4.1.95.Final",
        "io.netty"                      % "netty-transport-native-unix-common"         % "4.1.95.Final",
        ("software.amazon.cryptools"    % "AmazonCorrettoCryptoProvider"               % "2.2.0").classifier("linux-x86_64"),
        "org.agrona"                    % "agrona"                                     % "1.18.2",
        "io.aeron"                      % "aeron-all"                                  % "1.41.4",
        "io.aeron"                      % "aeron-driver"                               % "1.41.4",
        "io.aeron"                      % "aeron-client"                               % "1.41.4",
        "org.jctools"                   % "jctools-core"                               % "4.0.1",
        "com.typesafe"                  % "config"                                     % "1.4.1",
        "org.scala-lang.modules"        % "scala-parser-combinators_3"                 % "2.3.0",
        "org.scala-lang.modules"        % "scala-xml_3"                                % "2.2.0",
        "org.scala-lang.modules"        % "scala-parallel-collections_3"               % "1.0.4",
        "com.github.scopt"              % "scopt_3"                                    % "4.1.0",
        "com.maxmind.geoip2"            % "geoip2"                                     % "4.0.1",
        "com.maxmind.db"                % "maxmind-db"                                 % "3.0.0",
        "org.scalameta"                 % "munit_3"                                    % "1.0.0-M8",
        "org.scalameta"                 % "munit-scalacheck_3"                         % "1.0.0-M8",
        "org.scalacheck"                % "scalacheck_3"                               % "1.17.0",
        "qa.hedgehog"                   % "hedgehog-core_3"                            % "0.10.1",
        "qa.hedgehog"                   % "hedgehog-runner_3"                          % "0.10.1",
        "qa.hedgehog"                   % "hedgehog-sbt_3"                             % "0.10.1",
        "commons-codec"                 % "commons-codec"                              % "1.15",
        "commons-io"                    % "commons-io"                                 % "2.11.0",
        "commons-validator"             % "commons-validator"                          % "1.7",
        "org.apache.logging.log4j"      % "log4j-api"                                  % "2.20.0",
        "org.apache.logging.log4j"      % "log4j-core"                                 % "2.20.0",
        "org.apache.logging.log4j"      % "log4j-jul"                                  % "2.20.0",
        "org.apache.logging.log4j"      % "log4j-slf4j-impl"                           % "2.20.0",
        "org.apache.logging.log4j"      % "log4j-slf4j2-impl"                          % "2.20.0",
        "org.apache.commons"            % "commons-lang3"                              % "3.12.0",
        "org.bouncycastle"              % "bcpkix-jdk18on"                             % "1.75",
        "org.bouncycastle"              % "bcprov-jdk18on"                             % "1.75",
        "org.bouncycastle"              % "bctls-jdk18on"                              % "1.75",
        "it.unimi.dsi"                  % "fastutil"                                   % "8.5.12",
        "it.unimi.dsi"                  % "fastutil-core"                              % "8.5.12",
        "io.vertx"                      % "vertx-auth-common"                          % "4.4.4",
        "io.vertx"                      % "vertx-core"                                 % "4.4.4",
        "io.vertx"                      % "vertx-jdbc-client"                          % "4.4.4",
        "io.vertx"                      % "vertx-pg-client"                            % "4.4.4",
        "io.vertx"                      % "vertx-sql-client"                           % "4.4.4",
        "io.vertx"                      % "vertx-uri-template"                         % "4.4.4",
        "io.vertx"                      % "vertx-web"                                  % "4.4.4",
        "io.vertx"                      % "vertx-web-client"                           % "4.4.4",
        "io.vertx"                      % "vertx-web-common"                           % "4.4.4",
        "com.ongres.scram"              % "client"                                     % "2.1",
        "io.agroal"                     % "agroal-api"                                 % "1.16",
        "io.agroal"                     % "agroal-pool"                                % "1.16",
        "org.scala-js"                  % "scalajs-dom_sjs1_3"                         % "2.5.0",
        "io.github.cquiroz"             % "scala-java-time_sjs1_3"                     % "2.5.0",
        "com.password4j"                % "password4j"                                 % "1.7.1",
        "com.google.re2j"               % "re2j"                                       % "1.7",
        "com.github.alexandrnikitin"    % "bloom-filter_2.13"                          % "0.13.1",
        "com.raquo"                     % "airstream_sjs1_3"                           % "16.0.0",
        "com.raquo"                     % "domtypes_sjs1_3"                            % "17.1.0",
        "com.raquo"                     % "laminar_sjs1_3"                             % "16.0.0",
        "com.raquo"                     % "waypoint_sjs1_3"                            % "7.0.0",
        "com.raquo"                     % "ew_sjs1_3"                                  % "0.1.2",
        "com.thesamet.scalapb"          % "lenses_3"                                   % "0.11.13",
        "com.thesamet.scalapb"          % "scalapb-runtime_3"                          % "0.11.13",
        "org.roaringbitmap"             % "RoaringBitmap"                              % "0.9.45",
        "org.postgresql"                % "postgresql"                                 % "42.6.0",
        "com.googlecode.libphonenumber" % "libphonenumber"                             % "8.13.17",
        "com.github.ben-manes.caffeine" % "caffeine"                                   % "3.1.6",
        "net.openhft"                   % "affinity"                                   % "3.23.2",
        "net.openhft"                   % "zero-allocation-hashing"                    % "0.16",
        "dev.zio"                       % "izumi-reflect_3"                            % "2.3.8",
        "dev.zio"                       % "zio_3"                                      % "2.0.15",
        "dev.zio"                       % "zio-stacktracer_3"                          % "2.0.15",
        "dev.zio"                       % "zio-streams_3"                              % "2.0.15",
        "com.lihaoyi"                   % "pprint_3"                                   % "0.7.1",
        "com.lihaoyi"                   % "fansi_3"                                    % "0.2.14",
        "com.lihaoyi"                   % "geny_3"                                     % "0.6.10",
        "com.google.guava"              % "guava"                                      % "31.1-jre",
        "com.lmax"                      % "disruptor"                                  % "3.4.4",
        "com.typesafe.akka"             % "akka-actor_3"                               % "2.8.3",
        "com.typesafe.akka"             % "akka-stream_3"                              % "2.8.3",
        "com.typesafe.akka"             % "akka-http_3"                                % "10.5.2",
        "com.typesafe.akka"             % "akka-http-core_3"                           % "10.5.2",
        "com.typesafe.akka"             % "akka-parsing_3"                             % "10.5.2",
        "com.typesafe.play"             % "twirl-api_3"                                % "1.6.0-RC4",
        "com.typesafe.play"             % "twirl-compiler_3"                           % "1.6.0-RC4",
        "com.github.jwt-scala"          % "jwt-core_3"                                 % "9.2.0",
        "com.github.pureconfig"         % "pureconfig-core_3"                          % "0.17.4",
        "org.pcap4j"                    % "pcap4j-core"                                % "1.8.2",
        "org.pcap4j"                    % "pcap4j-packetfactory-static"                % "1.8.2",
        "com.clickhouse"                % "clickhouse-jdbc"                            % "0.4.6",
        "com.eatthepath"                % "fast-uuid"                                  % "0.2.0",
        "org.apache.lucene"             % "lucene-core"                                % "9.7.0",
        "org.apache.lucene"             % "lucene-facet"                               % "9.7.0",
        "org.apache.lucene"             % "lucene-highlighter"                         % "9.7.0",
        "org.apache.lucene"             % "lucene-queryparser"                         % "9.7.0",
        "io.micrometer"                 % "micrometer-core"                            % "1.11.2",
        "io.micrometer"                 % "micrometer-registry-prometheus"             % "1.11.2",
        "io.prometheus"                 % "simpleclient"                               % "0.16.0",
        "io.prometheus"                 % "simpleclient_common"                        % "0.16.0",
        "org.openjdk.jmh"               % "jmh-core"                                   % "1.33",
        "org.openjdk.jmh"               % "jmh-generator-annprocess"                   % "1.33",

        // Jitsi video bridge dependencies
        "org.jitsi"                    % "jitsi-metaconfig"             % "1.0-11-g8cf950e",
        "org.jitsi"                    % "sctp"                         % "1.0-9-g45bf9f2",
        "org.jitsi"                    % "jain-sip-ri-ossonly"          % "1.2.279-jitsi-oss1",
        "net.java.dev.jna"             % "jna"                          % "5.13.0",
        "org.opentelecoms.sdp"         % "java-sdp-nist-bridge"         % "1.2",
        "org.opentelecoms.sdp"         % "sdp-api"                      % "1.0",
        "org.opentelecoms.sip"         % "sip-api-1.2"                  % "1.2",
        "org.bitlet"                   % "weupnp"                       % "0.1.4",
        "com.fasterxml.jackson.core"   % "jackson-annotations"          % "2.15.0",
        "com.fasterxml.jackson.core"   % "jackson-core"                 % "2.15.0",
        "com.fasterxml.jackson.core"   % "jackson-databind"             % "2.15.0",
        "com.fasterxml.jackson.module" % "jackson-module-kotlin"        % "2.15.0",
        "com.fasterxml.jackson.module" % "jackson-module-scala_3"       % "2.15.0",
        "com.github.spotbugs"          % "spotbugs-annotations"         % "4.6.0",
        "org.minidns"                  % "minidns-core"                 % "1.0.4",
        "io.kotest"                    % "kotest-assertions-api-jvm"    % "5.3.2",
        "io.kotest"                    % "kotest-assertions-core-jvm"   % "5.3.2",
        "io.kotest"                    % "kotest-assertions-json-jvm"   % "5.3.2",
        "io.kotest"                    % "kotest-assertions-shared-jvm" % "5.3.2",
        "io.kotest"                    % "kotest-extensions-jvm"        % "5.3.2",
        "io.kotest"                    % "kotest-framework-api-jvm"     % "5.3.2",
        "io.kotest"                    % "kotest-property-jvm"          % "5.3.2",
        "io.kotest"                    % "kotest-runner-junit5-jvm"     % "5.3.2",
        "io.mockk"                     % "mockk-jvm"                    % "1.13.5",
        "io.mockk"                     % "mockk-dsl-jvm"                % "1.13.5",
        "org.mockito"                  % "mockito-core"                 % "5.3.0",
        "net.bytebuddy"                % "byte-buddy"                   % "1.14.5",
        "org.jetbrains.kotlinx"        % "kotlinx-coroutines-core-jvm"  % "1.6.4",
        "gnu.getopt"                   % "java-getopt"                  % "1.0.13",
        "jakarta.xml.bind"             % "jakarta.xml.bind-api"         % "4.0.0",
        "org.xmlunit"                  % "xmlunit-core"                 % "2.9.0",
        "org.reflections"              % "reflections"                  % "0.10.2",
        "io.pkts"                      % "pkts-buffers"                 % "3.0.10",
        "io.pkts"                      % "pkts-core"                    % "3.0.10",
        "javax.xml.bind"               % "jaxb-api"                     % "2.3.1",
        "org.jetbrains.kotlin"         % "kotlin-reflect"               % "1.6.21",

        // Netty5 dependencies
        "org.jetbrains"           % "annotations" % "23.0.0",
        "org.slf4j"               % "slf4j-api"   % "2.0.7",
        "io.projectreactor.tools" % "blockhound"  % "1.0.6.RELEASE"
      )
    )

    MakeTree()