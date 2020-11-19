load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_file")
load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")
load("@rules_jvm_external//:defs.bzl", "maven_install")

_SRC_FILEGROUP_BUILD_FILE_CONTENT = """
filegroup(
    name = "src",
    srcs = glob(["**/*.scala", "**/*.java"]),
    visibility = ["//visibility:public"]
)

filegroup(
    name = "meta",
    srcs = glob(["META-INF/**"], allow_empty = False),
    visibility = ["//visibility:public"]
)
"""

def scala_artifacts():
    return [
        "org.scala-lang:scala-compiler:2.13.4",
        "org.scala-lang:scala-library:2.13.4",
        "org.scala-lang:scala-reflect:2.13.4",
        "net.sourceforge.argparse4j:argparse4j:0.8.1",
        "org.jacoco:org.jacoco.core:0.7.5.201505241946",
        "com.lihaoyi:sourcecode_2.13:0.2.1,",
        "org.scala-sbt:test-interface:1.0",
        "org.scala-sbt:util-interface:1.4.3",
        "org.scala-sbt:util-logging_2.13:1.4.3",
        "org.scala-sbt:compiler-interface:1.4.3",
        "org.scala-sbt:zinc_2.13:1.4.3",
        "org.scala-sbt:zinc-persist_2.13:1.4.3",
        "org.scala-sbt:zinc-core_2.13:1.4.3",
        "org.scala-sbt:zinc-apiinfo_2.13:1.4.3",
        "org.scala-sbt:zinc-classpath_2.13:1.4.3",
    ]

def scala_repositories(java_launcher_version = "0.29.1"):
    maven_install(
        name = "annex",
        artifacts = scala_artifacts(),
        repositories = [
            "https://repo.maven.apache.org/maven2",
            "https://maven-central.storage-download.googleapis.com/maven2",
            "https://mirror.bazel.build/repo1.maven.org/maven2",
        ],
        fetch_sources = True,
        maven_install_json = "@rules_scala_annex//:annex_install.json",
    )

    java_stub_template_url = (
        "raw.githubusercontent.com/bazelbuild/bazel/" +
        java_launcher_version +
        "/src/main/java/com/google/devtools/build/lib/bazel/rules/java/" +
        "java_stub_template.txt"
    )

    http_file(
        name = "anx_java_stub_template",
        sha256 = "e6531a6539ec1e38fec5e20523ff4bfc883e1cc0209eb658fe82eb918eb49657",
        urls = [
            "https://mirror.bazel.build/%s" % java_stub_template_url,
            "https://%s" % java_stub_template_url,
        ],
    )

    http_archive(
        name = "compiler_bridge_2_13",
        build_file_content = _SRC_FILEGROUP_BUILD_FILE_CONTENT,
        sha256 = "a7feefe9f32d95ece54dfb479b2a48cc60a016ef840d21ed1fc31df86ca35e43",
        url = "https://repo.maven.apache.org/maven2/org/scala-sbt/compiler-bridge_2.13/1.4.3/compiler-bridge_2.13-1.4.3-sources.jar",
    )

    http_archive(
        name = "compiler_bridge_3_0",
        build_file_content = _SRC_FILEGROUP_BUILD_FILE_CONTENT,
        sha256 = "018d8052877eb56eb2be543b8ab1eec180b7121e313c1bbbbfad06e14b39ac46",
        url = "https://repo1.maven.org/maven2/org/scala-lang/scala3-sbt-bridge/3.0.0-M2/scala3-sbt-bridge-3.0.0-M2-bin-20201108-3938388-NIGHTLY-sources.jar",
    )

def scala_register_toolchains():
    # reserved for future use
    return ()
