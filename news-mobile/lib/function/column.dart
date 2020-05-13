import 'package:flutter/material.dart';
import 'package:mobile/function/cross_axis_alignment.dart';
import 'package:mobile/function/main_axis_alignment.dart';
import 'package:mobile/function/main_axis_size.dart';
import 'package:mobile/function/text_baseline.dart';
import 'package:mobile/function/text_direction.dart';
import 'package:mobile/function/vertical_direction.dart';
import 'package:mobile/function/widget.dart';

Column buildColumn(BuildContext context, Map<String, dynamic> attrs) {
  var mainAxisSize = lookupMainAxisSize(
    value: attrs['mainAxisSize'],
    fallback: MainAxisSize.max,
  );

  var crossAxisAlignment = lookupCrossAxisAlignment(
    value: attrs['crossAxisAlignment'],
    fallback: CrossAxisAlignment.center,
  );

  var textDirection = lookupTextDirection(
    value: attrs['textDirection'],
    fallback: TextDirection.ltr,
  );

  var verticalDirection = lookupVerticalDirection(
    value: attrs['verticalDirection'],
    fallback: VerticalDirection.down,
  );

  var mainAxisAlignment = lookupMainAxisAlignment(
    value: attrs['mainAxisAlignment'],
    fallback: MainAxisAlignment.start,
  );

  var textBaseline = lookupTextBaseline(
      value: attrs['textBaseline'], fallback: TextBaseline.alphabetic);

  List<Widget> children = List();
  if (attrs['children'] != null && attrs['children'].length > 0) {
    attrs['children'].forEach((child) => {
          children.add(buildWidget(
            context,
            child['type'],
            child['attrs'],
          ))
        });
  }

  return Column(
    mainAxisSize: mainAxisSize,
    crossAxisAlignment: crossAxisAlignment,
    textDirection: textDirection,
    verticalDirection: verticalDirection,
    mainAxisAlignment: mainAxisAlignment,
    textBaseline: textBaseline,
    children: children,
  );
}
