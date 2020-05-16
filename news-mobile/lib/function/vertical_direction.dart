import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

VerticalDirection lookupVerticalDirection(
  NewsClient client, {
  @required String value,
  VerticalDirection fallback = VerticalDirection.down,
}) {
  var verticalDirection = VerticalDirection.down;
  if (value == 'down') {
    verticalDirection = VerticalDirection.down;
  } else if (value == 'up') {
    verticalDirection = VerticalDirection.up;
  }
  return verticalDirection;
}
