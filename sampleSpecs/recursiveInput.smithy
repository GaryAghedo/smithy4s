namespace smithy4s.example

use alloy#restJson

@restJson
service RecursiveInputService {
  version: "0.0.1",
  operations: [RecursiveInputOperation],
}

@http(method: "PUT", uri: "/subscriptions")
@idempotent
operation RecursiveInputOperation {
  input: RecursiveInput,
}

structure RecursiveInput {
  hello: RecursiveInput
}
