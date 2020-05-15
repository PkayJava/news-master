import 'package:flutter/material.dart';
import 'package:mobile/function/widget.dart';

Scaffold buildScaffold(BuildContext context, Map<String, dynamic> attrs) {
  Widget appBar = buildWidget(
    context,
    attrs['appBar']['type'],
    attrs['appBar']['attrs'],
  );
  Widget drawer = attrs['drawer'] != null
      ? buildWidget(
          context,
          attrs['drawer']['type'],
          attrs['drawer']['attrs'],
        )
      : null;
  Widget body = buildWidget(
    context,
    attrs['body']['type'],
    attrs['body']['attrs'],
  );
  Widget floatingActionButton = buildWidget(
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
