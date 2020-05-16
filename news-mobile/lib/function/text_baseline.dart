import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

TextBaseline lookupTextBaseline(
  NewsClient client, {
  @required String value,
  @required TextBaseline fallback,
}) {
  var textBaseline = fallback;
  if (value == 'alphabetic') {
    textBaseline = TextBaseline.alphabetic;
  } else if (value == 'ideographic') {
    textBaseline = TextBaseline.ideographic;
  }
  return textBaseline;
}
