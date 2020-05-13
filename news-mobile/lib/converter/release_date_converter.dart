import 'package:intl/intl.dart';
import 'package:json_annotation/json_annotation.dart';

class ReleaseDateConverter implements JsonConverter<DateTime, String> {
  static final DateFormat FORMAT = DateFormat('yyyy-MM-dd');

  const ReleaseDateConverter();

  @override
  DateTime fromJson(String json) {
    if (json == null) {
      return null;
    } else {
      return FORMAT.parse(json);
    }
  }

  @override
  String toJson(DateTime json) {
    if (json == null) {
      return null;
    } else {
      return FORMAT.format(json);
    }
  }
}
