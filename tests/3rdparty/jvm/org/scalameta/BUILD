load("@rules_scala3//rules:scala.bzl", "scala_import")
scala_import(
    name = "junit_interface",
    jars = [
        "//external:jar/org/scalameta/junit_interface"
    ],
    runtime_deps = [
        "//3rdparty/jvm/junit:junit",
        "//3rdparty/jvm/org/scala_sbt:test_interface"
    ],
    visibility = [
        "//visibility:public"
    ]
)

scala_import(
    name = "munit",
    jars = [
        "//external:jar/org/scalameta/munit_3"
    ],
    runtime_deps = [
        "//3rdparty/jvm/junit:junit",
        "//3rdparty/jvm/org/scala_lang:scala3_library",
        ":junit_interface",
        ":munit_diff"
    ],
    visibility = [
        "//visibility:public"
    ]
)

scala_import(
    name = "munit_diff",
    jars = [
        "//external:jar/org/scalameta/munit_diff_3"
    ],
    runtime_deps = [
        "//3rdparty/jvm/org/scala_lang:scala3_library"
    ],
    visibility = [
        "//visibility:public"
    ]
)

scala_import(
    name = "munit_scalacheck",
    jars = [
        "//external:jar/org/scalameta/munit_scalacheck_3"
    ],
    runtime_deps = [
        "//3rdparty/jvm/org/scala_lang:scala3_library",
        "//3rdparty/jvm/org/scalacheck:scalacheck",
        ":munit",
        ":munit_diff"
    ],
    visibility = [
        "//visibility:public"
    ]
)
