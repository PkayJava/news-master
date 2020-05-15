import 'package:flutter/material.dart';
import 'package:mobile/function/icon_data.dart';

Icon buildIcon(BuildContext context, Map<String, dynamic> attrs) {
  IconData iconData = buildIconData(context, attrs['icon']);
  return Icon(iconData);
}
