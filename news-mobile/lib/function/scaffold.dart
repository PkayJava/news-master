import 'package:flutter/material.dart';
import 'package:mobile/function/widget.dart';

Scaffold buildScaffold(BuildContext context, Map<String, dynamic> attrs) {
  Widget appBar = buildWidget(
    context,
    attrs['appBar']['type'],
    attrs['appBar']['attrs'],
  );
  Widget drawer = buildWidget(
    context,
    attrs['drawer']['type'],
    attrs['drawer']['attrs'],
  );
  Scaffold(
    appBar: appBar,
    drawer: drawer,
  );
//  Scaffold(drawer: null,
//    appBar: null,
//    body: null,
//    primary: ,
//    backgroundColor: ,
//    drawerScrimColor: ,
//    extendBody: ,
//    bottomNavigationBar: ,
//    floatingActionButtonLocation: ,
//    bottomSheet: ,
//    drawerDragStartBehavior: ,
//    drawerEdgeDragWidth: ,
//    drawerEnableOpenDragGesture: ,
//    endDrawer: ,
//    endDrawerEnableOpenDragGesture: ,
//    extendBodyBehindAppBar: ,
//    floatingActionButton: ,
//    floatingActionButtonAnimator: ,
//    persistentFooterButtons: <Widget>[],
//    resizeToAvoidBottomInset: ,
//    resizeToAvoidBottomPadding: ,);
  return null;
}
