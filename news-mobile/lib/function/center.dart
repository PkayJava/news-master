import 'package:flutter/material.dart';
import 'package:mobile/function/widget.dart';

Center buildCenter(BuildContext context, Map<String, dynamic> attrs) {
  Widget child = buildWidget(
    context,
    attrs['child']['type'],
    attrs['child']['attrs'],
  );
  return Center(
    child: child,
  );
}
