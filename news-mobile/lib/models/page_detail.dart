import 'package:json_annotation/json_annotation.dart';

part 'page_detail.g.dart';

@JsonSerializable()
class PageDetailResponse {
  String title;

  Map<String, dynamic> widget;

  PageDetailResponse({
    this.title,
    this.widget,
  });

  factory PageDetailResponse.fromJson(Map<String, dynamic> json) =>
      _$PageDetailResponseFromJson(json);

  Map<String, dynamic> toJson() => _$PageDetailResponseToJson(this);
}
