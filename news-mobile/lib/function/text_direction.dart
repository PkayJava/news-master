import 'package:flutter/material.dart';

TextDirection lookupTextDirection({
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
