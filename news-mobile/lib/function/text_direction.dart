import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

TextDirection lookupTextDirection(
  NewsClient client, {
  @required String value,
  TextDirection fallback = TextDirection.ltr,
}) {
  var textDirection = fallback;
  if (value == 'ltr') {
    textDirection = TextDirection.ltr;
  } else if (value == 'rtl') {
    textDirection = TextDirection.rtl;
  }
  return textDirection;
}
