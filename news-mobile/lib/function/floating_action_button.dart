import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/signal.dart';
import 'package:mobile/function/widget.dart';

FloatingActionButton buildFloatingActionButton(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  var tooltip = attrs['tooltip'] as String;

  Widget child = buildWidget(
    client,
    context,
    attrs['child']['type'],
    attrs['child']['attrs'],
  );

  return FloatingActionButton(
    tooltip: tooltip,
    child: child,
    onPressed: () => {signal(client, context, attrs)},
  );
}
