load("@protobuf//bazel:proto_library.bzl", "proto_library")
load("@rules_scala3//rules:scala.bzl", "scala_library")
load("@rules_scala3//rules:scala_proto.bzl", "scala_proto_library")

proto_library(
    name = "events_proto",
    srcs = glob(["**/*.proto"]),
    deps = [
        "//:scalapb",
    ],
)

scala_proto_library(
    name = "events_scala_proto",
    deps = [
        ":events_proto",
    ],
)

scala_library(
    name = "events_scala",
    srcs = [":events_scala_proto"],
    scala = "@rules_scala3//scala:zinc_3_migration",
    deps = [
        "//3rdparty/jvm/com/thesamet/scalapb:scalapb_runtime",
    ],
)
