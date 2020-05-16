import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/cross_axis_alignment.dart';
import 'package:mobile/function/main_axis_alignment.dart';
import 'package:mobile/function/main_axis_size.dart';
import 'package:mobile/function/text_baseline.dart';
import 'package:mobile/function/text_direction.dart';
import 'package:mobile/function/vertical_direction.dart';
import 'package:mobile/function/widget.dart';

Column buildColumn(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  var mainAxisSize = lookupMainAxisSize(
    client,
    value: attrs['mainAxisSize'],
    fallback: MainAxisSize.max,
  );

  var crossAxisAlignment = lookupCrossAxisAlignment(
    client,
    value: attrs['crossAxisAlignment'],
    fallback: CrossAxisAlignment.center,
  );

  var textDirection = lookupTextDirection(
    client,
    value: attrs['textDirection'],
    fallback: TextDirection.ltr,
  );

  var verticalDirection = lookupVerticalDirection(
    client,
    value: attrs['verticalDirection'],
    fallback: VerticalDirection.down,
  );

  var mainAxisAlignment = lookupMainAxisAlignment(
    client,
    value: attrs['mainAxisAlignment'],
    fallback: MainAxisAlignment.start,
  );

  var textBaseline = lookupTextBaseline(
    client,
    value: attrs['textBaseline'],
    fallback: TextBaseline.alphabetic,
  );

  List<Widget> children = List();
  if (attrs['children'] != null && attrs['children'].length > 0) {
    attrs['children'].forEach((child) => {
          children.add(buildWidget(
            client,
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
