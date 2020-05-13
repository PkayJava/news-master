import 'package:json_annotation/json_annotation.dart';

class RuntimeConverter implements JsonConverter<String, dynamic> {
  const RuntimeConverter();

  @override
  String fromJson(dynamic json) {
    if (json <= 1) {
      return '$json min';
    } else {
      return '$json mins';
    }
  }

  @override
  dynamic toJson(String json) {
    return json;
  }
}
