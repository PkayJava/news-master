import 'package:flutter/material.dart';

MainAxisSize lookupMainAxisSize({
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
