import 'package:flutter/material.dart';

VerticalDirection lookupVerticalDirection({
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
