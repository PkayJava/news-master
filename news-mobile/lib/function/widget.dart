import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/app_bar.dart';
import 'package:mobile/function/center.dart';
import 'package:mobile/function/column.dart';
import 'package:mobile/function/floating_action_button.dart';
import 'package:mobile/function/icon.dart';
import 'package:mobile/function/scaffold.dart';
import 'package:mobile/function/text.dart';

Widget buildWidget(
  NewsClient client,
  BuildContext context,
  String type,
  Map<String, dynamic> attrs,
) {
  if (type == 'Text') {
    return buildText(client, context, attrs);
  } else if (type == 'Column') {
    return buildColumn(client, context, attrs);
  } else if (type == 'Scaffold') {
    return buildScaffold(client, context, attrs);
  } else if (type == 'AppBar') {
    return buildAppBar(client, context, attrs);
  } else if (type == 'Center') {
    return buildCenter(client, context, attrs);
  } else if (type == 'Icon') {
    return buildIcon(client, context, attrs);
  } else if (type == 'FloatingActionButton') {
    return buildFloatingActionButton(client, context, attrs);
  } else {
    return Text('Unknown');
  }
}
