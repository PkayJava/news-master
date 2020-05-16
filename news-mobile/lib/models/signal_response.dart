import 'package:json_annotation/json_annotation.dart';

part 'signal_response.g.dart';

@JsonSerializable()
class SignalResponse {
  String title;

  Map<String, dynamic> object;

  SignalResponse({
    this.title,
    this.object,
  });

  factory SignalResponse.fromJson(Map<String, dynamic> json) =>
      _$SignalResponseFromJson(json);

  Map<String, dynamic> toJson() => _$SignalResponseToJson(this);
}
