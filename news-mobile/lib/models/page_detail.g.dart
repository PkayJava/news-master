// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'page_detail.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PageDetailResponse _$PageDetailResponseFromJson(Map<String, dynamic> json) {
  return PageDetailResponse(
    title: json['title'] as String,
    widget: json['widget'] as Map<String, dynamic>,
  );
}

Map<String, dynamic> _$PageDetailResponseToJson(PageDetailResponse instance) =>
    <String, dynamic>{
      'title': instance.title,
      'widget': instance.widget,
    };
