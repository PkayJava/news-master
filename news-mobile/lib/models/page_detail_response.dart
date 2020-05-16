import 'package:json_annotation/json_annotation.dart';

part 'page_detail_response.g.dart';

@JsonSerializable()
class PageDetailResponse {
  String title;

  Map<String, dynamic> object;

  PageDetailResponse({
    this.title,
    this.object,
  });

  factory PageDetailResponse.fromJson(Map<String, dynamic> json) =>
      _$PageDetailResponseFromJson(json);

  Map<String, dynamic> toJson() => _$PageDetailResponseToJson(this);
}
