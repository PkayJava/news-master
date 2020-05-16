import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/widget.dart';

Center buildCenter(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  Widget child = buildWidget(
    client,
    context,
    attrs['child']['type'],
    attrs['child']['attrs'],
  );
  return Center(
    child: child,
  );
}
