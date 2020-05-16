// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'page_detail_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PageDetailResponse _$PageDetailResponseFromJson(Map<String, dynamic> json) {
  return PageDetailResponse(
    title: json['title'] as String,
    object: json['object'] as Map<String, dynamic>,
  );
}

Map<String, dynamic> _$PageDetailResponseToJson(PageDetailResponse instance) =>
    <String, dynamic>{
      'title': instance.title,
      'object': instance.object,
    };
