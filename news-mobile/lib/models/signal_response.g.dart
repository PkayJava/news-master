// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'signal_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SignalResponse _$SignalResponseFromJson(Map<String, dynamic> json) {
  return SignalResponse(
    title: json['title'] as String,
    object: json['object'] as Map<String, dynamic>,
  );
}

Map<String, dynamic> _$SignalResponseToJson(SignalResponse instance) =>
    <String, dynamic>{
      'title': instance.title,
      'object': instance.object,
    };
