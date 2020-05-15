import 'package:flutter/material.dart';
import 'package:mobile/function/widget.dart';

FloatingActionButton buildFloatingActionButton(
    BuildContext context, Map<String, dynamic> attrs) {
  var tooltip = attrs['tooltip'] as String;

  Widget child = buildWidget(
    context,
    attrs['child']['type'],
    attrs['child']['attrs'],
  );

  return FloatingActionButton(
    tooltip: tooltip,
    child: child,
  );
}
