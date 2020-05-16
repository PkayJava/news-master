import 'dart:developer';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/widget.dart';

void signal(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) async {
  client.signal();
  log(attrs['__uuid']);
}
