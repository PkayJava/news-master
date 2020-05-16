import 'package:flutter/material.dart';
import 'package:mobile/clients/news_client.dart';
import 'package:mobile/function/widget.dart';

AppBar buildAppBar(
    NewsClient client, BuildContext context, Map<String, dynamic> attrs) {
  double toolbarOpacity = 1.0;
  if (attrs['toolbarOpacity'] != null) {
    toolbarOpacity = double.parse(attrs['toolbarOpacity']);
  }

  bool primary = true;
  if (attrs['primary'] != null) {
    primary = (attrs['primary'] == 'true' ||
        attrs['primary'] == '1' ||
        attrs['primary'] == 'yes');
  }

  Widget leading = attrs['leading'] != null
      ? buildWidget(
          client,
          context,
          attrs['leading']['type'],
          attrs['leading']['attrs'],
        )
      : null;

  Widget title = buildWidget(
    client,
    context,
    attrs['title']['type'],
    attrs['title']['attrs'],
  );

  double elevation = 0;
  if (attrs['elevation'] != null) {
    elevation = double.parse(attrs['elevation']);
  }

  bool centerTitle = true;
  if (attrs['centerTitle'] != null) {
    centerTitle = (attrs['centerTitle'] == 'true' ||
        attrs['centerTitle'] == '1' ||
        attrs['centerTitle'] == 'yes');
  }

  bool automaticallyImplyLeading = true;
  if (attrs['automaticallyImplyLeading'] != null) {
    automaticallyImplyLeading = (attrs['automaticallyImplyLeading'] == 'true' ||
        attrs['automaticallyImplyLeading'] == '1' ||
        attrs['automaticallyImplyLeading'] == 'yes');
  }

  double titleSpacing = 0;
  if (attrs['titleSpacing'] != null) {
    titleSpacing = double.parse(attrs['titleSpacing']);
  }

  double bottomOpacity = 0;
  if (attrs['bottomOpacity'] != null) {
    bottomOpacity = double.parse(attrs['bottomOpacity']);
  }

  bool excludeHeaderSemantics = true;
  if (attrs['excludeHeaderSemantics'] != null) {
    excludeHeaderSemantics = (attrs['excludeHeaderSemantics'] == 'true' ||
        attrs['excludeHeaderSemantics'] == '1' ||
        attrs['excludeHeaderSemantics'] == 'yes');
  }

  return AppBar(
    toolbarOpacity: toolbarOpacity,
    primary: primary,
    leading: leading,
    title: title,
    elevation: elevation,
    centerTitle: centerTitle,
    automaticallyImplyLeading: automaticallyImplyLeading,
    titleSpacing: titleSpacing,
    bottomOpacity: bottomOpacity,
    excludeHeaderSemantics: excludeHeaderSemantics,
  );
}
