import 'package:flutter/material.dart';
import 'package:mobile/function/app_bar.dart';
import 'package:mobile/function/column.dart';
import 'package:mobile/function/scaffold.dart';
import 'package:mobile/function/text.dart';

Widget buildWidget(
  BuildContext context,
  String type,
  Map<String, dynamic> attrs,
) {
  if (type == 'Text') {
    return buildText(context, attrs);
  } else if (type == 'Column') {
    return buildColumn(context, attrs);
  } else if (type == 'Scaffold') {
    return buildScaffold(context, attrs);
  } else if (type == 'AppBar') {
    return buildAppBar(context, attrs);
  } else {
    return Text('Unknown');
  }
}
