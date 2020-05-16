import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

Text buildText(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  return Text(attrs['data']);
}
