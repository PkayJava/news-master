import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/widget.dart';

Scaffold buildScaffold(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  Widget appBar = buildWidget(
    client,
    context,
    attrs['appBar']['type'],
    attrs['appBar']['attrs'],
  );
  Widget drawer = attrs['drawer'] != null
      ? buildWidget(
          client,
          context,
          attrs['drawer']['type'],
          attrs['drawer']['attrs'],
        )
      : null;
  Widget body = buildWidget(
    client,
    context,
    attrs['body']['type'],
    attrs['body']['attrs'],
  );
  Widget floatingActionButton = buildWidget(
    client,
    context,
    attrs['floatingActionButton']['type'],
    attrs['floatingActionButton']['attrs'],
  );
  return Scaffold(
    appBar: appBar,
    drawer: drawer,
    body: body,
    floatingActionButton: floatingActionButton,
  );
}
