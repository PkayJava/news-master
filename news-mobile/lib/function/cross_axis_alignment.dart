import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

CrossAxisAlignment lookupCrossAxisAlignment(
  NewsClient client, {
  @required String value,
  CrossAxisAlignment fallback = CrossAxisAlignment.center,
}) {
  var crossAxisAlignment = fallback;
  if (value == 'start') {
    crossAxisAlignment = CrossAxisAlignment.start;
  } else if (value == 'center') {
    crossAxisAlignment = CrossAxisAlignment.center;
  } else if (value == 'end') {
    crossAxisAlignment = CrossAxisAlignment.end;
  } else if (value == 'baseline') {
    crossAxisAlignment = CrossAxisAlignment.baseline;
  } else if (value == 'stretch') {
    crossAxisAlignment = CrossAxisAlignment.stretch;
  }
  return crossAxisAlignment;
}
