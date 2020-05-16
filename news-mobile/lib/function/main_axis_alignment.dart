import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';

MainAxisAlignment lookupMainAxisAlignment(
  NewsClient client, {
  @required String value,
  MainAxisAlignment fallback = MainAxisAlignment.start,
}) {
  var mainAxisAlignment = fallback;
  if (value == 'start') {
    mainAxisAlignment = MainAxisAlignment.start;
  } else if (value == 'center') {
    mainAxisAlignment = MainAxisAlignment.center;
  } else if (value == 'end') {
    mainAxisAlignment = MainAxisAlignment.end;
  } else if (value == 'spaceEvenly') {
    mainAxisAlignment = MainAxisAlignment.spaceEvenly;
  } else if (value == 'spaceBetween') {
    mainAxisAlignment = MainAxisAlignment.spaceBetween;
  } else if (value == 'spaceAround') {
    mainAxisAlignment = MainAxisAlignment.spaceAround;
  }
  return mainAxisAlignment;
}
