import 'package:json_annotation/json_annotation.dart';

class DoubleConverter implements JsonConverter<double, dynamic> {
  const DoubleConverter();

  @override
  double fromJson(dynamic json) {
    if (json is int) {
      return json.toDouble();
    } else if (json is double) {
      return json;
    } else {
      return -1;
    }
  }

  @override
  dynamic toJson(double json) {
//    return 'abc';
    return 1;
  }
}
