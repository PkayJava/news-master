import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

MainAxisSize lookupMainAxisSize(
  NewsClient client, {
  @required String value,
  MainAxisSize fallback = MainAxisSize.max,
}) {
  var mainAxisSize = fallback;
  if (value == 'max') {
    mainAxisSize = MainAxisSize.max;
  } else if (value == 'min') {
    mainAxisSize = MainAxisSize.min;
  }
  return mainAxisSize;
}
