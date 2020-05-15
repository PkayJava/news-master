import 'package:flutter/material.dart';
import 'package:mobile/function/app_bar.dart';
import 'package:mobile/function/center.dart';
import 'package:mobile/function/column.dart';
import 'package:mobile/function/floating_action_button.dart';
import 'package:mobile/function/icon.dart';
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
  } else if (type == 'Center') {
    return buildCenter(context, attrs);
  } else if (type == 'Icon') {
    return buildIcon(context, attrs);
  } else if (type == 'FloatingActionButton') {
    return buildFloatingActionButton(context, attrs);
  } else {
    return Text('Unknown');
  }
}
