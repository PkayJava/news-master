import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/icon_data.dart';

Icon buildIcon(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  IconData iconData = lookupIconData(
    client,
    value: attrs['icon'],
  );
  return Icon(iconData);
}
